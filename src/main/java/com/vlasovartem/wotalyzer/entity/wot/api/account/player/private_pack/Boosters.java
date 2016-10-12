package com.vlasovartem.wotalyzer.entity.wot.api.account.player.private_pack;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 10/09/16.
 * Личные резервы
 */
class Boosters {

    /* Количество личных резервов */
    private int count;
    /* Время окончания действия */
    private LocalDateTime expirationTime;
    /* Статус личных резервов */
    private BoostersState state;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public BoostersState getState() {
        return state;
    }

    public void setState(BoostersState state) {
        this.state = state;
    }
}
