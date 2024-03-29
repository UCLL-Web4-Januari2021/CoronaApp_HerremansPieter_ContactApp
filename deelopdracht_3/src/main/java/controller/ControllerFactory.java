package controller;

import db.PersonRepositoryStub;

import java.util.ServiceConfigurationError;

public class ControllerFactory {

    public RequestHandler getHandler(String handlerName, PersonRepositoryStub model) throws ServiceConfigurationError{
        RequestHandler handler = null;
        if (handlerName == null || handlerName.isEmpty())
        {
            handlerName = "home";
        }
        try{
            Class handlerClass = Class.forName("controller."+ handlerName);
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return handler;
    }
}
