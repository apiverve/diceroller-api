# Dice Roller API - Dart/Flutter Client

Dice Roller is a tool for rolling dice using standard RPG notation (XdY format). It supports multiple dice, various die sizes, modifiers, and provides statistics including min, max, average, and theoretical values for gaming and simulations.

[![pub package](https://img.shields.io/pub/v/apiverve_diceroller.svg)](https://pub.dev/packages/apiverve_diceroller)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Dice Roller API](https://apiverve.com/marketplace/diceroller?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_diceroller: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_diceroller/apiverve_diceroller.dart';

void main() async {
  final client = DicerollerClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'dice': '1d6',
      'modifier': 5
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "dice_notation": "3d6",
    "num_dice": 3,
    "num_sides": 6,
    "modifier": 5,
    "rolls": [
      2,
      6,
      5
    ],
    "total": 13,
    "total_with_modifier": 18,
    "min_roll": 2,
    "max_roll": 6,
    "average_roll": 4.33,
    "theoretical_min": 3,
    "theoretical_max": 18,
    "theoretical_average": 10.5,
    "expression": "3d6+5"
  }
}
```

## API Reference

- **API Home:** [Dice Roller API](https://apiverve.com/marketplace/diceroller?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/diceroller](https://docs.apiverve.com/ref/diceroller?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
