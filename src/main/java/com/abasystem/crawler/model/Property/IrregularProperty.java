package com.abasystem.crawler.model.Property;

import com.abasystem.crawler.mapper.ModelMapper;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class IrregularProperty extends ModelMapper {

    public IrregularProperty(String title, String description, String date, String url, String phone) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nIrregularProperty{" +
                "\n\t title='" + title + '\'' +
                ",\n\t description='" + description + '\'' +
                ",\n\t date='" + date + '\'' +
                ",\n\t url='" + url + '\'' +
                ",\n\t phone ='" + phone + '\'' +
                '}';
    }
}
