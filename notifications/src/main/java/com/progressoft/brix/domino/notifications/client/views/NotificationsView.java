package com.progressoft.brix.domino.notifications.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface NotificationsView extends View{
    void showIn(Content content);
}