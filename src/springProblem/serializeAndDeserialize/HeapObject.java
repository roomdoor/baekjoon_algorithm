package springProblem.serializeAndDeserialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HeapObject implements Serializable, Cloneable {

	private final String name;

	public HeapObject(String name) {
		this.name = name;
	}

	@Override
	protected HeapObject clone() throws CloneNotSupportedException {
		return (HeapObject) super.clone();
	}

	public static void main(String[] args)
		throws CloneNotSupportedException, IOException, ClassNotFoundException {
		HeapObject t1 = new HeapObject("test");
		System.out.println("t1 = " + t1);
		HeapObject t2 = t1.clone();
		System.out.println("t2 = " + t2);
		HeapObject t3 = serializeAndDeserialize(t1);
		System.out.println("t3 = " + t3);
		HeapObject t4 = t1;
		System.out.println("t4 = " + t4);
		// 여기서 heap 에 존재하는 HeapObject 인스턴스 갯수
	}

	private static HeapObject serializeAndDeserialize(HeapObject t1)
		throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.out.println("baos = " + baos);

		ObjectOutputStream oos = new ObjectOutputStream(baos);
		System.out.println("oos = " + oos);
		oos.writeObject(t1);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		return (HeapObject) ois.readObject();
	}
}
