package com.br.nossas.ideias.error;

public class ResourceNotFoundDetails extends ErrorDetails {

    private ResourceNotFoundDetails() {

    }

    public static final class Builder {
        private String title;
        private int status;
        private long timestamp;
        private String detail;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.setDeveloperMessage(developerMessage);
            resourceNotFoundDetails.setDetail(detail);
            resourceNotFoundDetails.setStatus(status);
            resourceNotFoundDetails.setTimestamp(timestamp);
            resourceNotFoundDetails.setTitle(title);
            return resourceNotFoundDetails;
        }
    }
}
