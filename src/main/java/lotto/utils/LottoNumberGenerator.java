package lotto.utils;

import lotto.domain.LottoNo;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int LOTTO_NUMBER_BOUND = 50;

    private LottoNumberGenerator() {

    }

    public static List<LottoNo> generate(int... numbers) {
        return generate(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }
    
    public static List<LottoNo> generate(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNo::create)
                .collect(Collectors.toList());
    }

    public static List<LottoNo> generate() {
        List<LottoNo> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
            lottoNumbers.add(generateRandomLotto());
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static LottoNo generateRandomLotto() {
        return LottoNo.create(new Random().nextInt(LOTTO_NUMBER_BOUND));
    }
}
