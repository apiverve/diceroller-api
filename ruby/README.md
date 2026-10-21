# Dice Roller API - Ruby Gem

Dice Roller is a dice API that simulates RPG dice rolls using standard notation like 3d6 or 2d20 with optional modifiers. It outputs the individual die outcomes, die count, and the sum of all rolls.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_diceroller'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_diceroller
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_diceroller'

# Initialize the client
client = APIVerve::Diceroller::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  dice: "1d6",
  modifier: 5
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ dice: "1d6", modifier: 5 })
  puts response["data"]
rescue APIVerve::Diceroller::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Diceroller::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Diceroller::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/diceroller?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/diceroller?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/diceroller?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
