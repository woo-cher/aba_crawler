package com.abasystem.crawler.Model.Property;

import com.abasystem.crawler.Mapper.ModelMapper;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class IrregularProperty extends ModelMapper {

    public IrregularProperty(String title, String description, String date, String url) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
    }

    @Override
    public String toString() {
        return "\nIrregularProperty{" +
                "\n\t title='" + title + '\'' +
                ",\n\t description='" + description + '\'' +
                ",\n\t date='" + date + '\'' +
                ",\n\t url='" + url + '\'' +
                '}';
    }
}