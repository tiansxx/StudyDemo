package jdk8.com.tian.inter;
/**
 * 函数接口
 * 接口中指定有一个方法
 * @author tian
 *
 * @param <S>
 * @param <T>
 */

@FunctionalInterface
public interface Converter<S, T> {
	T convert(S source);
}
