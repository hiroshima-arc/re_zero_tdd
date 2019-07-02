package rental.domain.generics;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Total<Source, Target extends Accumulate<Target>> {
  List<Source> source;
  Function<Source, Target> map;

  public Total(List<Source> source, Function<Source, Target> map) {
    this.source = source;
    this.map = map;
  }

  public Target sum() {
    return targetStream().reduce(Target::add).get();
  }

  public Target sumWith(Target initial) {
    return targetStream().reduce(initial, Target::add);
  }

  private Stream<Target> targetStream() {
    return source.stream().map(map);
  }
}
