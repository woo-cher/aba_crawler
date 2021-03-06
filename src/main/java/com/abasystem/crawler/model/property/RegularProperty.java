package com.abasystem.crawler.model.property;

import com.abasystem.crawler.builder.RegularPostBuilder;
import com.abasystem.crawler.mapper.ModelMapper;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RegularProperty extends ModelMapper {

    private String address;
    private String price;
    private String managementPrice;
    private String propertyType;
    private String roomCount;
    private String floor;
    private String managementCategory;
    private String heatingType;
    private String options;
    private String movePossibleDate;

    public RegularProperty(RegularPostBuilder builder) {
        this.title = builder.getTitle();
        this.url = builder.getUrl();
        this.date = builder.getDate();
        this.phone = builder.getPhone();
        this.address = builder.getAddress();
        this.price = builder.getPrice();
        this.managementPrice = builder.getManagementPrice();
        this.propertyType = builder.getPropertyType();
        this.roomCount = builder.getRoomCount();
        this.floor = builder.getFloor();
        this.managementCategory = builder.getManagementCategory();
        this.heatingType = builder.getHeatingType();
        this.options = builder.getOptions();
        this.description = builder.getDescription();
        this.movePossibleDate = builder.getMovePossibleDate();
    }

    @Override
    public String toString() {
        return "\nRegularProperty {" +
                "\n\t title='" + title + '\'' +
                ",\n\t url='" + url + '\'' +
                ",\n\t date=" + date +
                ",\n\t phone='" + phone + '\'' +
                ",\n\t address='" + address + '\'' +
                ",\n\t price='" + price + '\'' +
                ",\n\t managementPrice='" + managementPrice + '\'' +
                ",\n\t propertyType='" + propertyType + '\'' +
                ",\n\t roomCount='" + roomCount + '\'' +
                ",\n\t floor='" + floor + '\'' +
                ",\n\t managementCategory='" + managementCategory + '\'' +
                ",\n\t heatingType='" + heatingType + '\'' +
                ",\n\t options='" + options + '\'' +
                ",\n\t description='" + description + '\'' +
                ",\n\t movePossibleDate='" + movePossibleDate + '\'' +
                "\n}";
    }
}
