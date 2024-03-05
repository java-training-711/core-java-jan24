package org.example10;

import java.text.MessageFormat;

// user defined unchecked exception with place holder
public class App21 {

    private static class ErrorConstant{
        public static final String VOTE_AGE_VALIDATION_MSG="{0} is not allowed to vote as he is below {1}";
    }

    private static class MessageTemplateResolver{
        public static String resolve(String template, String... params){
            MessageFormat messageFormat = new MessageFormat(template);
            String formattedMessage = messageFormat.format(params);
            return formattedMessage;
        }
    }
    private static class DataValidationException extends RuntimeException{
        public DataValidationException(String template, String... params) {
            super(MessageTemplateResolver.resolve(template, params));
        }
    }

    public static void main(String[] args) {

        int x = 17;
        if(x < 18){
            throw new DataValidationException(ErrorConstant.VOTE_AGE_VALIDATION_MSG, "John", "18");
        }
    }
}
