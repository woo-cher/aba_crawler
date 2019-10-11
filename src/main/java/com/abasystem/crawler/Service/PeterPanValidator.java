package com.abasystem.crawler.Service;

import com.abasystem.crawler.Model.InvalidKeyWord;
import com.abasystem.crawler.Model.Type.RegularType;
import com.abasystem.crawler.Model.ValidKeyword;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ValidationStrategy;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class PeterPanValidator implements ValidationStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PeterPanValidator.class);

    @Override
    public boolean isPropertyPost(Elements elements) {
        parameterHandler(elements);

        for (ValidKeyword keyword : ValidKeyword.values()) {
            if (elements.select(Naver.POST_MINI_TITLE).text().equals(keyword.getName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isInvalidPost(Elements elements) {
        parameterHandler(elements);

        for (InvalidKeyWord keyWord : InvalidKeyWord.values()) {
            if (elements.text().contains(keyWord.getName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isRegularPost(Elements elements) {
        parameterHandler(elements);

        for (RegularType type : RegularType.values()) {
            String code = type.getCode();
            if (elements.select("#".concat(code)).text() == null) {
                return false;
            }

            if (elements.select("#".concat(code)).text().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    private void parameterHandler(Object object) {
        if (object == null || ObjectUtils.isEmpty(object)) {
            logger.info("Null Object {}", object);
            throw new NullPointerException("Elements is null");
        }
    }
}