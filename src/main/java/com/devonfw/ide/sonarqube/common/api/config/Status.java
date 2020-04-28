package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The status of the {@link Configuration}.
 *
 * @see Configuration#status()
 */
public class Status {

  private final List<String> errorsMutable;

  private final List<String> errors;

  private boolean errorsReported;

  String source;

  /**
   * The constructor.
   */
  public Status() {

    super();
    this.errorsMutable = new ArrayList<>();
    this.errors = Collections.unmodifiableList(this.errorsMutable);
    this.source = Configuration.ARCHITECTURE_JSON;
  }

  /**
   * @return the {@link List} of error messages collected whilst {@link Configuration#initialize(String) initializing}
   *         the {@link Configuration}.
   */
  public List<String> getErrors() {

    return this.errors;
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

    Logger logger = Logger.getGlobal();

    assert !this.errorsReported;
    if (this.errorsMutable.isEmpty()) {
      logger.log(Level.WARNING, "ERROR: Illegal configuration file: " + this.source);
    }
    this.errorsMutable.add(error);
    logger.log(Level.WARNING, "ERROR: " + error);
  }

}
