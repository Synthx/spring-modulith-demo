package org.yezebi.demo.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModuleArchitectureTest {
  final ApplicationModules modules = ApplicationModules.of(DemoModulithApplication.class);

  @Test
  public void verifyModuleBeans() {
    modules.forEach(System.out::println);
  }

  @Test
  public void verifyModularArchitecture() {
    modules.verify();
  }

  @Test
  public void createModuleDocumentation() {
    new Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
  }
}
