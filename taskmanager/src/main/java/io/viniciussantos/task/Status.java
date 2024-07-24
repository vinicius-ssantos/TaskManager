package io.viniciussantos.task;

public enum Status {
   PENDING("PENDING"),
   COMPLETED("COMPLETED");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status.toLowerCase();
    }


}