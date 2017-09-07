package tests;

import shapes2d.Vec2;

public class TestVec2 {

	public static void main(String[] args) {
		Vec2 v1 = new Vec2(1.5, 6.5);
		System.out.println(v1.getInstances());
		
		Vec2 v2 = new Vec2(4.8, -3.2);
		System.out.println(v1.getInstances());
		System.out.println(v2.getInstances());
		
		Vec2 v3 = new Vec2(-2.6, 3.8);
		System.out.println(v1.getInstances());
		System.out.println(v2.getInstances());
		System.out.println(v3.getInstances());
		System.out.println(Vec2.getInstances());
		
	}

}
