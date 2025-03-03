package com.rolandsall.kafka.template.mediator;

import com.rolandsall.kafka.template.mediator.command.Command;
import com.rolandsall.kafka.template.mediator.command.CommandHandler;
import com.rolandsall.kafka.template.mediator.command.CommandHandlerNotFoundException;
import com.rolandsall.kafka.template.mediator.command.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Component
@RequiredArgsConstructor
public class Mediator implements IMediator {

    private final ApplicationContext applicationContext;


    @Override
    @SuppressWarnings("unchecked")
    public <T extends Command> Result handle(T command) {
        return applicationContext.getBeansOfType(CommandHandler.class)
                .values()
                .stream()
                .filter(commandHandler -> {
                    Type[] genericInterfaces = commandHandler.getClass().getGenericInterfaces();
                    for (Type genericInterface : genericInterfaces) {
                        if (genericInterface instanceof ParameterizedType parameterizedType) {
                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                            if (actualTypeArguments.length > 0 && actualTypeArguments[0] instanceof Class<?> handlerType
                                    && handlerType.isAssignableFrom(command.getClass())) {
                                    return true;
                                }

                        }
                    }
                    return false;
                })
                .findFirst()
                .orElseThrow(() -> new CommandHandlerNotFoundException(command))
                .handle(command);
    }
}
