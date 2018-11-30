package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The status of the {@link Configuration}.
 *
 * @see Configuration#status()
 */
public class Status {

  private final List<String> errors;

  private final List<String> errorsView;

  private boolean errorsReported;

  String source;

  /**
   * The constructor.
   */
  public Status() {

    super();
    this.errors = new ArrayList<>();
    this.errorsView = Collections.unmodifiableList(this.errors);
    this.source = Configuration.ARCHITECTURE_JSON;
  }

  /**
   * @return the {@link List} of error messages collected whilst {@link Configuration#initialize(String) initializing}
   *         the {@link Configuration}.
   */
  public List<String> getErrors() {

    return this.errorsView;
  }

  /**
   * @return {@code true} if the {@link #getErrors() errors} have already been reported, {@code false} otherwise
   *         (initial default).
   * @see #setErrorsReported()
   */
  public boolean isErrorsReported() {

    return this.errorsReported;
  }

  /**
   * Set {@link #isErrorsReported() errorsReported} to {@code true}.
   */
  public void setErrorsReported() {

    this.errorsReported = true;
  }

  /**
   * @param error the error to add.
   */
  void addError(String error) {

    assert !this.errorsReported;
    if (this.errors.isEmpty()) {
      System.out.println("ERROR: Illegal configuration file: " + this.source);
    }
    this.errors.add(error);
    System.out.println("ERROR: " + error);
  }

}
