package br.espm.canoafurada.cabin;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "cabin")
public class CabinEntity {

    public CabinEntity(){}

    public CabinEntity(CabinDto cabin){
        this.maxPeople = cabin.getMaxPeople();
        this.pricePerson = cabin.getPricePerson();
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "max_people", nullable = false)
    private int maxPeople;

    @Column(name = "price_person", nullable = false)
    private double pricePerson;

    public CabinDto toDTO(){
        var cabin = new CabinDto();
        cabin.setId(id);
        cabin.setMaxPeople(maxPeople);
        cabin.setPricePerson(pricePerson);

        return cabin;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(double pricePerson) {
        this.pricePerson = pricePerson;
    }
}
