package com.abasystem.crawler.Service;

import com.abasystem.crawler.Model.InvalidKeyWord;
import com.abasystem.crawler.Model.Type.RegularType;
import com.abasystem.crawler.Model.ValidKeyword;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ValidationStrategy;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Qualifier("customValidator")
public class CustomValidator implements ValidationStrategy {
    private static final Logger logger = LoggerFactory.getLogger(CustomValidator.class);

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

    @Override
    public boolean isExistPhoneNumber(Elements elements) {
        String regex = "[0일|01|영일|영1]{2}[0|영][-?|.?| ?].{4}[-?|.?].{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(elements.text());
        logger.info("Els.text()? {}", elements.text());

        if(matcher.find()) {
            return true;
        }

        return false;
    }

    private void parameterHandler(Elements elements) {
        if (elements.isEmpty()) {
            logger.info("Null Elements {}", elements);
            throw new NullPointerException("쿼리 선택자가 잘못됬거나 카페 사용자 권한이 없습니다.");
        }
    }
}