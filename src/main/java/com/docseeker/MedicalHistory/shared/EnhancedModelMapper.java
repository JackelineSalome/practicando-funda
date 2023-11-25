package com.docseeker.MedicalHistory.shared;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class EnhancedModelMapper extends ModelMapper {
    public EnhancedModelMapper() {
      super();
      this.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(item -> this.map(item, targetClass)).collect(Collectors.toList());
    }
}
