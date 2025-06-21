# File: .gitpod.Dockerfile
FROM gitpod/workspace-base

# Install SDKMAN and Java 24.0.1 (Temurin distribution)
RUN curl -s "https://get.sdkman.io" | bash \
    && bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 24.0.1-tem && sdk default java 24.0.1-tem"

# Install Angular CLI globally using npm
RUN npm install -g @angular/cli
