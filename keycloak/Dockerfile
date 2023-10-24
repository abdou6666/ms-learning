    # Use the official Keycloak image for version 12
    FROM quay.io/keycloak/keycloak:12.0.4

    # Copy any custom configuration files if needed
    COPY ./realm-export.json /opt/jboss/keycloak/standalone/configuration/

    # Expose the ports that Keycloak uses
    EXPOSE 8180

    # Set environment variables if needed
    ENV KEYCLOAK_USER=admin
    ENV KEYCLOAK_PASSWORD=admin

    # Define the command to run Keycloak on port 8180
    CMD ["-b", "0.0.0.0", "-Djboss.http.port=8180"]
