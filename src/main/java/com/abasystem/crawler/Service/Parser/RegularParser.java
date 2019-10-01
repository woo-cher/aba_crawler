package com.abasystem.crawler.Service.Parser;

import com.abasystem.crawler.Builder.RegularPostBuilder;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Strategy.ParseStrategy;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegularParser implements ParseStrategy<RegularProperty> {
    private static final Logger logger = LoggerFactory.getLogger(RegularParser.class);

    private String date;

    @Override
    public RegularProperty parse(Document document, String url, String title) {
        logger.debug("RegularParser.parse initialize");
        date = document.select(".date").text();

        return new RegularPostBuilder(title, url, date)
                .address(document.select("#pp_location").text())
                .price(document.select("#pp_fee").text())
                .managementPrice(document.select("#pp_maintenance").text())
                .phone(document.select("#pp_contact").text())
                .propertyType(document.select("#pp_building_type").text())
                .roomCount(document.select("#pp_room_count").text())
                .floor(document.select("#pp_floor").text())
                .managementCategory(document.select("#pp_maintenance_include").text())
                .movePossibleDate(document.select("#pp_moving_date").text())
                .option(document.select("#pp_options").text())
                .heatingType(document.select("#pp_heating").text())
                .description(document.select("#pp_description").text())
                .build();
    }
}