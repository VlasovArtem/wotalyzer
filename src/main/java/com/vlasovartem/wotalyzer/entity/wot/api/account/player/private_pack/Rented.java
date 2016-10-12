package com.vlasovartem.wotalyzer.entity.wot.api.account.player.private_pack;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 10/09/16.
 * Аренда техники
 */
class Rented {

    /* Компенсация аренды в кредитах */
    private long compensationCredits;
    /* Компенсация аренды в золоте */
    private long compensationGold;
    /* Время окончания аренды */
    private LocalDateTime expirationTime;
    /* Идентификатор техники в аренде */
    private long tankId;

}
