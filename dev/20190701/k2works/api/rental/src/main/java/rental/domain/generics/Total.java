package rental.domain.generics;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
* 集計
* @param <Source>
* @param <Target>
*/
public class Total<Source, Target extends Accumulate<Target>> {
  List<Source> source;
  Function<Source, Target> convertToValues;

  public Total(List<Source> sources, Function<Source, Target> convertToValues) {
    this.source = sources;
    this.convertToValues = convertToValues;
  }

  public Target sum() {
    return targetStream().reduce(Target::add).get();
  }

  public Target sumWith(Target initial) {
    return targetStream().reduce(initial, Target::add);
  }

  private Stream<Target> targetStream() {
    return source.stream().map(convertToValues);
  }
}
