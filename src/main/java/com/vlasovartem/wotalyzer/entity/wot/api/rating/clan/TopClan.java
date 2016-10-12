package com.vlasovartem.wotalyzer.entity.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ExcludeReason;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.components.RatingData;

import java.util.Map;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class TopClan {

    /* Идентификатор клана */
    private int clanId;
    /* Название клана */
    private String clanName;
    /* Тег клана */
    private String clanTag;
    /* exclude_reasons - Причины, по которым не были рассчитаны определённые категории рейтингов. Содержит данные в формате ключ-значение, где ключом является название категории, а значением причина. Возможные причины: inactivity - Неактивность на протяжении 28 дней newbies_measure - В клане меньше десяти игроков limits - Условия ранка не выполнены blocked - Клан заблокирован other - Технические причины */
    private Map<ExcludeReason, String> excludeReasons;
    /* Среднее количество боёв */
    private RatingData battlesCountAvg;
    /* Среднее количество боёв в день */
    private RatingData battlesCountAvgDaily;
    /* Показатель клановой эффективности */
    private RatingData efficiency;
    /* Эло-рейтинг клана в Битвах за Укрепрайон */
    private RatingData fbEloRating;
    /* Эло-рейтинг клана в Битвах за Укрепрайон в абсолютном дивизионе */
    private RatingData fbEloRating10;
    /* Эло-рейтинг клана в Битвах за Укрепрайон в чемпионском дивизионе */
    private RatingData fbEloRating8;
    /* Среднее значение глобального рейтинга */
    private RatingData globalRatingAvg;
    /* Средневзвешенное значение глобального рейтинга */
    private RatingData globalRatingWeightedAvg;
    /* Эло-рейтинг на Глобальной карте */
    private RatingData gmEloRating;
    /* Эло-рейтинг на Глобальной карте в абсолютном дивизионе */
    private RatingData gmEloRating10;
    /* Эло-рейтинг на Глобальной карте в среднем дивизионе */
    private RatingData gmEloRating6;
    /* Эло-рейтинг на Глобальной карте в чемпионском дивизионе */
    private RatingData gmEloRating8;
    /* Рейтинг в Битвах за Укрепрайон */
    private RatingData ratingFort;
    /* Среднее количество техники 10 уровня на игрока клана */
    private RatingData v10lAvg;
    /* Средний процент побед */
    private RatingData winsRatioAvg;

}
