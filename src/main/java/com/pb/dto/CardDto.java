package com.pb.dto;

/**
 * @author @bkalika
 */
public class CardDto {
    private Long id;
    private SenderDto ownerDto;
    private Long number;

    public CardDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SenderDto getOwner_dto() {
        return ownerDto;
    }

    public void setOwner_dto(SenderDto ownerDto) {
        this.ownerDto = ownerDto;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
