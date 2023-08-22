package id.zakariandys.mockagent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

@SpringBootApplication
public class MockAgentApplication implements ClassFileTransformer {

	@Override
	public byte[] transform(
			ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {

		if ("id/zakariandys/restsample/api/MyRestAPI".equals(className)) {
			try {
				ClassPool classPool = ClassPool.getDefault();
				CtClass ctClass = classPool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer));
				CtMethod ctMethod = ctClass.getDeclaredMethod("printHelloWorld");
				ctMethod.setBody("{ return \"Modified Hello\"; }"); // Modify the method body

				return ctClass.toBytecode();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return classfileBuffer;
	}

	public static void main(String[] args) {
		SpringApplication.run(MockAgentApplication.class, args);
	}

}
