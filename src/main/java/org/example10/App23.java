package org.example10;

import java.text.MessageFormat;

// user defined unchecked exception with place holder
public class App23 {

    private static class ErrorConstant{
        public static final String VOTE_AGE_VALIDATION_MSG="{0} is not allowed to vote as he is below {1}:BE-101:400";
    }

    private static class ErrorInfo{
        private String message;
        private String errorCode;
        private String httpStatus;

        public ErrorInfo(String message, String errorCode, String httpStatus) {
            this.message = message;
            this.errorCode = errorCode;
            this.httpStatus = httpStatus;
        }

        @Override
        public String toString() {
            return "ErrorInfo{" +
                    "message='" + message + '\'' +
                    ", errorCode='" + errorCode + '\'' +
                    ", httpStatus='" + httpStatus + '\'' +
                    '}';
        }
    }

    private static class MessageTemplateResolver{
        public static String resolve(String template, String... params){
            MessageFormat messageFormat = new MessageFormat(template);
            String formattedMessage = messageFormat.format(params);
            return formattedMessage;
        }
    }
    private static class DataValidationException extends RuntimeException{

        private ErrorInfo errorInfo;

        public DataValidationException(String template, String... params) {
            super(MessageTemplateResolver.resolve(template.split(":")[0], params));
            String elements[] = template.split(":");
            errorInfo = new ErrorInfo(getMessage(), elements[1], elements[2]);
        }

        public ErrorInfo getErrorInfo() {
            return errorInfo;
        }
    }

    public static void main(String[] args) {

        try {
            serviceMethod();
        } catch (RuntimeException e) {
           if(e instanceof DataValidationException){
               DataValidationException ex = (DataValidationException) e;
               System.out.println(ex.getErrorInfo());
           }
        }
    }

    private static void serviceMethod() {
        int x = 17;
        if(x < 18){
            throw new DataValidationException(ErrorConstant.VOTE_AGE_VALIDATION_MSG, "John", "18");
        }
    }
}
