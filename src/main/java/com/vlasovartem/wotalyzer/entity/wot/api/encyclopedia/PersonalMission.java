package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vlasovartem.wotalyzer.deserializers.OperationDeserializer;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_mission.Operation;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/personalmissions/
 */
public class PersonalMission extends MainEntity {

    /* Описание кампании */
    private String description;
    /* Название кампании */
    private String name;
    /* Операции кампании */
    @JsonDeserialize(using = OperationDeserializer.class)
    private List<Operation> operations;

    @Override
    @JsonProperty("campaign_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
