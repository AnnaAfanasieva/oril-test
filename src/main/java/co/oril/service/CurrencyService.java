package co.oril.service;

import co.oril.model.Currency;
import co.oril.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void fetchCryptocurrencyPrices(Currency currency) {
        currencyRepository.insert(currency);
    }

    //TODO повернути запис із найнижчою ціною вибраної криптовалюти
    //(інакше - помилка)
    public void minPrice() {

    }

    //TODO повернути запис із найвищою ціною вибраної криптовалюти
    //(інакше - помилка)
    public void maxPrice() {

    }

    //TODO повернути вибрану сторінку з вибраною кількістю елементів
    //сортування за умовчанням має здійснюватися за ціною від найнижчої до найвищої

    //Параметри запиту [page_number] і [page_size] мають бути необов’язковими
    //якщо вони відсутні, ви повинні встановити для них значення за замовчуванням page=0, size=10
    public void listOfPrices() {

    }

    //TODO згенерувати звіт CSV, зберегти у файлі
    //поля: назва криптовалюти, мінімальна ціна, максимальна ціна
    //Отже, у цьому звіті має бути лише три записи, тому що у нас є три різні криптовалюти
    public void csvReport() {

    }
}
