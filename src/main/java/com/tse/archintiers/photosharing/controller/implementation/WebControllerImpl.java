package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.WebController;
import com.tse.archintiers.photosharing.model.dto.Action;
import com.tse.archintiers.photosharing.model.dto.PhotoVisualizationAction;
import java.util.Locale;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebControllerImpl implements WebController {

    @MessageMapping("/do-action")
    @SendTo("/show-photos/action-occurred")
    @Override
    public String actionOccurred(PhotoVisualizationAction action) throws Exception {
        return Action.valueOf(action.getAction().toUpperCase(Locale.ROOT)).toString();
    }
}
