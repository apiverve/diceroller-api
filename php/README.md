# Dice Roller API - PHP Package

Dice Roller is a dice API that simulates RPG dice rolls using standard notation like 3d6 or 2d20 with optional modifiers. It outputs the individual die outcomes, die count, and the sum of all rolls.

## Installation

Install via Composer:

```bash
composer require apiverve/diceroller
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Diceroller\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'dice' => '1d6',
    'modifier' => 5
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Diceroller\Client;
use APIVerve\Diceroller\Exceptions\APIException;
use APIVerve\Diceroller\Exceptions\ValidationException;

try {
    $response = $client->execute(['dice' => '1d6', 'modifier' => 5]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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
      6,
      4,
      4
    ],
    "total": 14,
    "total_with_modifier": 19,
    "min_roll": 4,
    "max_roll": 6,
    "average_roll": 4.67,
    "theoretical_min": 3,
    "theoretical_max": 18,
    "theoretical_average": 10.5,
    "expression": "3d6+5"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/diceroller?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/diceroller?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/diceroller?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
