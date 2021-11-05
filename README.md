# Card payment processing with Checkout API
[Português](README.pt.md) / [Español](README.es.md)

## :computer: Technologies
- Java 11
- [Spring Boot](https://spring.io/projects/spring-boot) 2.5.4
- [Maven](https://maven.apache.org/) (dependency manager)

## 💡 Requirements
- Java 8 or higher (follow the download instructions [here](https://java.com/en/download/help/download_options.html)).
- [Maven](https://maven.apache.org/) (dependency manager).
- [Read our instructions](https://www.mercadopago.com/developers/en/guides/overview#bookmark_el_desarrollo_con_c%C3%B3digo) on how to create an application at the Mercado Pago Developer Panel in order to acquire your public key and access token. They will grant you access to Mercado Pago's public APIs.

## :gear: Installation
1. Clone the project.
```bash
git clone https://github.com/mercadopago/card-payment-sample-java.git
```

2. Go to the project's folder.
```bash
cd card-payment-sample-java
```

## 🌟 How to run it
1. Run the following command to start the application:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--mercado_pago_sample_public_key=YOUR_PUBLIC_KEY --mercado_pago_sample_access_token=YOUR_ACCESS_TOKEN"
``` 

2. Remember to replace the values of `YOUR_PUBLIC_KEY` and `YOUR_ACCESS_TOKEN` with the corresponding [credentials](https://www.mercadopago.com/developers/panel) from your account.

3. Navigate to http://localhost:8080 in your browser.

### :test_tube: Testing
On our [testing instructions](https://www.mercadopago.com/developers/en/guides/online-payments/checkout-api/testing) you'll find **[credit cards](https://www.mercadopago.com/developers/en/guides/online-payments/checkout-api/testing#bookmark_test_cards)** that can be used along with this sample and a guide on how to create **[test users](https://www.mercadopago.com/developers/en/guides/online-payments/checkout-api/testing#bookmark_how_to_create_users)**.

## :handshake: Contributing
You can contribute to this project by reporting problems and bugs. Before opening an issue, make sure to read our [code of conduct](CODE_OF_CONDUCT.md).

## :bookmark: License
MIT License. Copyright (c) 2021 - Mercado Pago <br/>
For more information, see the [LICENSE](LICENSE) file.