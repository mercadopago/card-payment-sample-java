# Card payment processing with Checkout API

## Using Spring Boot

### Previous requirements
- Java 11 or higher
- Read our [testing instructions](https://www.mercadopago.com/developers/en/guides/payments/api/testing)
- Get your credentials at [Mercado Pago Developers Panel](https://www.mercadopago.com/developers/panel)

### How to run it

- Clone or download this project
- Open a terminal and run the following command to start the application: `java -Dpublic_key="YOUR_PUBLIC_KEY" -Daccess_token="YOUR_ACCESS_TOKEN" -jar target/card-payment-sample-java-0.0.1.jar` 
  - Remember to replace values _YOUR_PUBLIC_KEY_ and _YOUR_ACCESS_TOKEN_ with the corresponding Credentials from your account.
- Navigate to http://localhost:8080 in your browser
- Done! Now test the integration :white_check_mark: