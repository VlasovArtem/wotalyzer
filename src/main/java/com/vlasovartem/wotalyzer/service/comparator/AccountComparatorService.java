package com.vlasovartem.wotalyzer.service.comparator;

import com.vlasovartem.wotalyzer.entity.AccountWN8CompareData;

import java.util.List;

/**
 * Created by artemvlasov on 10/12/2016.
 */
public interface AccountComparatorService {

    List<AccountWN8CompareData> compareUsersWN8(List<Long> accountIds);

}
