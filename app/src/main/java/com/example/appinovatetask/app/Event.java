package com.example.appinovatetask.app;

class Event<T> {
    private T content;

    Event(T content) {
        this.content = content;
    }

    private boolean hasBeenHandled = false;

    public void setHasBeenHandled(boolean hasBeenHandled) {
        this.hasBeenHandled = hasBeenHandled;
    }

    /**
     * Returns the content and prevents its use again.
     */
    T getContentIfNotHandled() {
        if (hasBeenHandled) {
            return null;
        } else {
            hasBeenHandled = true;
            return content;
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    T peekContent() {
        return content;
    }
}
