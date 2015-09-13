package com.tian.annotation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

//编译时处理注解
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.tian.annotation.Assignment")
public class AssignmentProcess extends AbstractProcessor {

	TypeElement assignTypeElement;
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		Elements elementUtils = processingEnv.getElementUtils();
		assignTypeElement = elementUtils.getTypeElement("com.tian.annotation.Assignment");
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(assignTypeElement);
		for (Element ele : elements) {
			processAssignment(ele);
		}
		return false;
	}
	
	private void processAssignment(Element ele) {
		List<? extends AnnotationMirror> annotations = ele.getAnnotationMirrors();
		for (AnnotationMirror mirror : annotations) {
			if (mirror.getAnnotationType().asElement().equals(assignTypeElement)) {
				Map<? extends ExecutableElement, ? extends AnnotationValue> values = 
						mirror.getElementValues();
				System.out.println("===============" + values);
				
			}
		}
		
		
		
		
	}

}
