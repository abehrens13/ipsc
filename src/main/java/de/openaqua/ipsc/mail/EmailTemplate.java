package de.openaqua.ipsc.mail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

/**
 * @author pavan.solapure
 * 
 *         Stuff taken from https://github.com/pavansolapure/opencodez-samples
 *         https://www.opencodez.com/java/java-mail-framework-using-spring-boot.htm
 * 
 *         on
 *         https://www.opencodez.com/java/java-mail-framework-using-spring-boot.htm
 *         is an example template which could be used for this class.
 */
public class EmailTemplate {

	private String templateId;

	private String template;

	private Map<String, String> replacementParams;

	public EmailTemplate(String templateId) {
		this.templateId = templateId;
		try {
			this.template = loadTemplate(templateId);
		} catch (Exception e) {
			this.template = Constants.BLANK;
		}
	}

	private String loadTemplate(String templateId) throws EmailException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("email-templates/" + templateId).getFile());
		String content = Constants.BLANK;
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			throw new EmailException("Could not read template with ID = " + templateId);
		}
		return content;
	}

	public String getTemplate(Map<String, String> replacements) {
		String cTemplate = this.getTemplate();

		if (!AppUtil.isObjectEmpty(cTemplate)) {
			for (Map.Entry<String, String> entry : replacements.entrySet()) {
				cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
			}
		}

		return cTemplate;
	}

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the replacementParams
	 */
	public Map<String, String> getReplacementParams() {
		return replacementParams;
	}

	/**
	 * @param replacementParams the replacementParams to set
	 */
	public void setReplacementParams(Map<String, String> replacementParams) {
		this.replacementParams = replacementParams;
	}

}