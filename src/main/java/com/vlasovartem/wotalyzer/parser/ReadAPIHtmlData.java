import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by artemvlasov on 08/09/16.
 */
public class ReadAPIHtmlData {

    private static String responseBlockId = "response_block";
    private static String parametersBlockId = "parameters_block";
    private static List<String> existingParameters = Arrays.asList("application_id", "language", "fields");
    private static String apiConstantsPattern = "List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS";
    private static StringBuilder apiConstantsMock = new StringBuilder(apiConstantsPattern);
    private static String requiredConstantsPattern = "List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS";
    private static StringBuilder requiredConstantsMock = new StringBuilder(requiredConstantsPattern);
    private Map<String, String> possibleValueMap = updatePossibleValueMap();
    private File finishedFolder = new File("finished");

    public static void main(String[] args) throws IOException {
        ReadAPIHtmlData readAPIHtmlData = new ReadAPIHtmlData();
        File folder = new File("WOT_API_HTML");
        if (folder.isDirectory()) {
            folder.listFiles();
            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    File parsedFile = new File(file.getName() + ".txt");
                    if (!parsedFile.exists() && !readAPIHtmlData.checkFinished(parsedFile.getName())) {
                        parsedFile.createNewFile();
                        Document document1 = Jsoup
                                .parse(file, Charset.defaultCharset().toString());
                        ArrayList<String> data = new ArrayList<>();
                        data.add("String BASIC_URL = \"" + readAPIHtmlData.getAPIURL(document1) + "\";");
                        document1.getElementById(parametersBlockId).getElementsByTag("tr")
                                .stream().skip(1)
                                .map(readAPIHtmlData::createParametersString)
                                .filter(s -> !s.isEmpty())
                                .collect(Collectors.toCollection(() -> data));
                        data.add(apiConstantsMock.toString() + ");");
                        data.add(requiredConstantsMock.toString() + ");");
                        Stream.of(document1.getElementById(responseBlockId).getElementsByTag("tr"))
                                .flatMap(Collection::stream)
                                .map(readAPIHtmlData::createFieldString).collect(Collectors.toCollection(() -> data));
                        readAPIHtmlData.writeDataToTheFile(parsedFile, data);
                        resetBuilders();
                    }
                }
            }
        }
    }

    private static void resetBuilders() {
        apiConstantsMock = new StringBuilder(apiConstantsPattern);
        requiredConstantsMock = new StringBuilder(requiredConstantsPattern);
    }

    private Map<String, String> updatePossibleValueMap() {
        Map<String, String> possibleValueMap = new HashMap<>();
        possibleValueMap.put("numeric", "int");
        possibleValueMap.put("string", "String");
        possibleValueMap.put("timestamp", "LocalDateTime");
        possibleValueMap.put("list of integers", "List<Integer>");
        possibleValueMap.put("boolean", "boolean");
        possibleValueMap.put("float", "float");
        return possibleValueMap;
    }

    private String createFieldString(Element element) {
        Elements td = element.getElementsByTag("td");
        String fieldPattern = "private %s %s;";
        StringBuilder stringBuilder = new StringBuilder();
        if (td.size() == 3) {
            if (td.get(1).text().isEmpty() || !possibleValueMap.containsKey(td.get(1).text())) {
                stringBuilder.append(createComment(td.get(0).text() + " - " + td.get(2).text())).append("\n");
            } else {
                stringBuilder.append(createComment(td.get(2).text()))
                        .append("\n")
                        .append(String.format(fieldPattern, possibleValueMap.get(td.get(1).text()), prepareFieldName(td.get(0).text())));
            }
        }
        return stringBuilder.toString();
    }

    private String createParametersString(Element element) {
        Elements td = element.getElementsByTag("td");
        String parameterPattern = "String %s = \"%s\";";
        String fieldValue = "";
        String fieldName = "";
        String parameterString = "";
        StringBuilder parameterInfo = new StringBuilder();
        parameterInfo.append("/*");
        for (int i = 0; i < td.size(); i++) {
            if (i == 0) {
                for (Element element2 : td.get(i).getElementsByTag("span")) {
                    if (existingParameters.contains(element2.text())) {
                        return "";
                    } else if ("*".equals(element2.text())) {
                        requiredConstantsMock.append(", ").append(fieldName);
                    } else {
                        fieldName = element2.text().toUpperCase() + "_PARAM";
                        fieldValue = element2.text();
                        apiConstantsMock.append(", ").append(fieldName);
                    }
                }
                parameterString = String.format(parameterPattern, fieldName, fieldValue);
            } else if(i == 1) {
                parameterInfo.append(" ") .append(td.get(i).getElementsByTag("input").attr("placeholder"));
            } else {
                parameterInfo.append(" ").append(td.get(i).getElementsByClass("param-description_text").text());
            }

        }
        return parameterInfo.append(" */").append("\n").append(parameterString).toString();
    }

    private String createComment(String comment) {
        return String.format("/* %s */", comment);
    }

    private String prepareFieldName(String name) {
        String convertedName = "";
        for (String s : name.split("_")) {
            if (convertedName.isEmpty()) {
                convertedName += s;
            } else {
                convertedName += StringUtils.capitalize(s);
            }
        }
        return convertedName;
    }

    private String getAPIURL(Document document) {
        String href = document.getElementsByAttribute("data-clipboard-text").first().attr("href");
        return href.split("/\\?")[0];
    }

    private boolean checkFinished(String fileName) {
        if (Objects.nonNull(finishedFolder) && finishedFolder.isDirectory()) {
            File[] files = finishedFolder.listFiles();
            if(Objects.nonNull(files))
                return Stream.of(files).anyMatch(file -> file.getName().equalsIgnoreCase(fileName));
        }
        return false;
    }

    private void writeDataToTheFile(File file, List<String> data) {
        try {
            FileUtils.writeLines(file, data, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

