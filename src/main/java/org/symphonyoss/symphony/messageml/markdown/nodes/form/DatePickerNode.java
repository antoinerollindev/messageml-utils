package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import org.apache.commons.lang3.StringUtils;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class DatePickerNode extends FormElementNode {
  private final static String MARKDOWN = "Date Picker";

  private String label;
  private String tooltip;
  private String placeholder;

  public DatePickerNode(String label, String tooltip, String placeholder) {
    super(MARKDOWN, placeholder);
    this.label = addEscapeCharacter(label);
    this.tooltip = addEscapeCharacter(tooltip);
    this.placeholder = addEscapeCharacter(placeholder);
  }

  @Override
  public String getText() {
    return Stream.of(label, tooltip, placeholder)
        .filter(StringUtils::isNotEmpty)
        .collect(() -> new StringJoiner("][",":[", "]").setEmptyValue(""),
            StringJoiner::add,
            StringJoiner::merge)
        .toString();
  }
}
