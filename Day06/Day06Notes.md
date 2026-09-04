# Java String Manipulation Notes (Low-Level / Non-Builtin)

---

## 1. Key Rules & Fundamentals

* **ASCII Conversion Rules:**
    * Lowercase to Uppercase: `ch - 32` (e.g., `'a'` -> `'A'`)
    * Uppercase to Lowercase: `ch + 32` (e.g., `'A'` -> `'a'`)
* **ASCII Bounds:**
    * Uppercase letters: `'A'` to `'Z'` (`65` to `90`)
    * Lowercase letters: `'a'` to `'z'` (`97` to `122`)
    * Digits: `'0'` to `'9'` (`48` to `57`)
* **Frequency Mapping:**
    * Use `int[26]` array for English alphabet frequency.
    * Index calculation: `ch - 'a'` maps `'a'..'z'` to indices `0..25`.
* **Whitespace Identification:**
    * Spaces, tabs, and newlines: `' '`, `'\t'`, `'\n'`, `'\r'`.

---

## 2. Common Algorithm Patterns

| Feature | Low-Level Pattern | Notes |
| :--- | :--- | :--- |
| **Word Counting** | Track previous character (`prevchar`) | Count increments when transitioning from whitespace to non-whitespace. |
| **Title Casing** | Capitalize when `i == 0` OR `prevchar` is whitespace | Decrement character by 32 if lowercase. |
| **Anagram Check** | Single `int[26]` frequency array | Increment index for String 1, decrement for String 2. Final array must be all zeros. |
| **Longest Word** | Accumulate `currentword` until hitting whitespace | Compare `currentword.length()` with `longestword.length()`. Check tail word after loop. |
| **Palindrome** | Two-pointer approach (`left` and `right`) | Move inward skipping non-alphanumeric chars; convert case before direct comparison. |
| **Custom Split** | Traversal + `StringBuilder` | Count delimiter occurrences to size array; append chars to `StringBuilder` and flush on delimiter. |

---

## 3. Performance Summary

* **String Concatenation (`+` in loops):** Creates new `String` objects on every iteration ($O(N^2)$ time/memory complexity).
* **`StringBuilder`:** Uses a mutable dynamic buffer ($O(N)$ time complexity). Preferred for sequential character operations.