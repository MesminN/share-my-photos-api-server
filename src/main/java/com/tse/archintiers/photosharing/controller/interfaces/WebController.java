package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.PhotoVisualizationAction;

public interface WebController {

    String actionOccurred(PhotoVisualizationAction action) throws Exception;
}
