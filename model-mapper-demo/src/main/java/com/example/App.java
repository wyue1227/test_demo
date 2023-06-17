package com.example;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yue
 */
public class App {

    public static void main(String[] args) {

        List<DtoA> aList = new ArrayList<>();
        DtoA a1 = new DtoA(1, "1", "1");
        DtoA a2 = new DtoA(2, "2", "2");
        aList.add(a1);
        aList.add(a2);

        PropertyMap<DtoA, DtoB> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                // userNo:2 -> userNo:22
                using(new AbstractConverter<Integer, Integer>() {
                    @Override
                    protected Integer convert(Integer source) {
                        return source == 2 ? 22 : source;
                    }
                }).map(source.getUserNo(), destination.getUserNo());

                // userName:2 -> userName:22
                using(new AbstractConverter<String, String>() {
                    @Override
                    protected String convert(String source) {
                        return Objects.equals(source, "2") ? "22" : source;
                    }
                }).map(source.getUserName(), destination.getUserName());

                // userPassword:1 -> null, 2 -> 2
                Condition<String, String> passwordCondition = ctx -> "2".equals(ctx.getSource());
                when(passwordCondition).map(source.getUserPassword(), destination.getUserPassword());
            }
        };

        List<DtoB> result = new App().mapList(aList, DtoB.class, propertyMap);
        for (DtoB tmDtoB : result) {
            System.out.println(tmDtoB);
        }
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, PropertyMap<S, T> propertyMap) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (propertyMap != null) {
            modelMapper.addMappings(propertyMap);
        }
        return source.stream().map(element -> modelMapper.map(element, targetClass)).toList();
    }
}
