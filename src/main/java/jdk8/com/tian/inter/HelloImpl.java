package jdk8.com.tian.inter;

/**
 * 如果实现的多个接口，且不同的接口中有同样签名的方法，则需要实现类实现该接口方法
 * @author tian
 *
 */
public class HelloImpl implements IHello, IHi {

	@Override
	public void hello() {
		IHello.super.hello();
	}
	
}
