package com.nttdata.service.regularExpression.impl;

import com.nttdata.service.regularExpression.EmailRegularExpressionService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailRegularExpressionServiceImpl implements EmailRegularExpressionService {
    @Override
    public boolean isValid(String email) {
        final Pattern emailRegex = Pattern.compile(
                "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
                Pattern.CASE_INSENSITIVE);
        return emailRegex.matcher(email).matches();
    }
}
