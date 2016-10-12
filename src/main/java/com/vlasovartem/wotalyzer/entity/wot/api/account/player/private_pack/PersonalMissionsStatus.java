package com.vlasovartem.wotalyzer.entity.wot.api.account.player.private_pack;

/**
 * Created by artemvlasov on 10/09/16.
 * NONE - миссия недоступна
 * UNLOCKED - миссия доступна
 * NEED_GET_MAIN_REWARD - не получено основное вознаграждение
 * MAIN_REWARD_GOTTEN - основное вознаграждение получено
 * NEED_GET_ADD_REWARD - не получено второстепенное вознаграждение
 * NEED_GET_ALL_REWARDS - не получено ни одно вознаграждение
 * ALL_REWARDS_GOTTEN - все вознаграждения получены
 */
enum PersonalMissionsStatus {
    NONE, UNLOCKED, NEED_GET_MAIN_REWARD, MAIN_REWARD_GOTTEN, NEED_GET_ADD_REWARD, NEED_GET_ALL_REWARDS, ALL_REWARDS_GOTTEN
}
