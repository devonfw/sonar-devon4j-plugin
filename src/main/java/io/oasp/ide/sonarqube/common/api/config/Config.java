package io.oasp.ide.sonarqube.common.api.config;

/**
 * @author ssabah
 *
 */
public class Config {

  private BusinessArchitecture businessArchitecture;

  /**
   * @return businessArchitecture
   */
  public BusinessArchitecture getBusinessArchitecture() {

    if (this.businessArchitecture == null) {
      this.businessArchitecture = new BusinessArchitecture();
    }
    return this.businessArchitecture;
  }

  /**
   * @param businessArchitecture new value of {@link #getbusinessArchitecture}.
   */
  public void setBusinessArchitecture(BusinessArchitecture businessArchitecture) {

    this.businessArchitecture = businessArchitecture;
  }

}
