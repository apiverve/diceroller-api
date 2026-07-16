# [Dice Roller API](https://apiverve.com/marketplace/diceroller?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)

Dice Roller is a tool for rolling dice using standard RPG notation (XdY format). It supports multiple dice, various die sizes, modifiers, and provides statistics including min, max, average, and theoretical values for gaming and simulations.

The Dice Roller API provides a simple, reliable way to integrate dice roller functionality into your applications. Built for developers who need production-ready dice roller capabilities without the complexity of building from scratch.

**[View API Details →](https://apiverve.com/marketplace/diceroller?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API Status](https://img.shields.io/badge/Status-Active-green.svg)](https://apiverve.com/marketplace/diceroller?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)
[![Method](https://img.shields.io/badge/Method-GET-blue.svg)](#)
[![Platform](https://img.shields.io/badge/Platform-Multi--Platform-orange.svg)](#installation)

**Available on:**
[![npm](https://img.shields.io/badge/npm-CB3837?style=flat&logo=npm&logoColor=white)](https://www.npmjs.com/package/@apiverve/diceroller)
[![NuGet](https://img.shields.io/badge/NuGet-004880?style=flat&logo=nuget&logoColor=white)](https://www.nuget.org/packages/APIVerve.API.DiceRoller)
[![PyPI](https://img.shields.io/badge/PyPI-3776AB?style=flat&logo=python&logoColor=white)](https://pypi.org/project/apiverve-diceroller/)
[![RubyGems](https://img.shields.io/badge/RubyGems-E9573F?style=flat&logo=rubygems&logoColor=white)](https://rubygems.org/gems/apiverve_diceroller)
[![Packagist](https://img.shields.io/badge/Packagist-F28D1A?style=flat&logo=packagist&logoColor=white)](https://packagist.org/packages/apiverve/diceroller)
[![Go](https://img.shields.io/badge/Go-00ADD8?style=flat&logo=go&logoColor=white)](#-go)
[![Dart](https://img.shields.io/badge/Dart-0175C2?style=flat&logo=dart&logoColor=white)](https://pub.dev/packages/apiverve_diceroller)
[![JitPack](https://img.shields.io/badge/JitPack-2E7D32?style=flat&logo=android&logoColor=white)](#-android-jitpack)

---

## Quick Start

### Using JavaScript

```javascript
async function callDiceRollerAPI() {
    try {
        const params = new URLSearchParams({
            dice: '3d6',
            modifier: 5
        });

        const response = await fetch(`https://api.apiverve.com/v1/diceroller?${params}`, {
            method: 'GET',
            headers: {
                'x-api-key': 'YOUR_API_KEY_HERE'
            }
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error('Error:', error);
    }
}

callDiceRollerAPI();
```

### Using cURL

```bash
curl -X GET "https://api.apiverve.com/v1/diceroller?dice=3d6&modifier=5" \
  -H "x-api-key: YOUR_API_KEY_HERE"
```

**Get your API key:** [https://apiverve.com](https://apiverve.com)

**📁 For more examples, see the [examples folder](./examples/)**

---

## Installation

Choose your preferred programming language:

### 📦 NPM (JavaScript/Node.js)

```bash
npm install @apiverve/diceroller
```

[**View NPM Package →**](https://www.npmjs.com/package/@apiverve/diceroller) | [**Package Code →**](./npm/)

---

### 🔷 NuGet (.NET/C#)

```bash
dotnet add package APIVerve.API.DiceRoller
```

[**View NuGet Package →**](https://www.nuget.org/packages/APIVerve.API.DiceRoller) | [**Package Code →**](./nuget/)

---

### 🐍 Python (PyPI)

```bash
pip install apiverve-diceroller
```

[**View PyPI Package →**](https://pypi.org/project/apiverve-diceroller/) | [**Package Code →**](./python/)

---

### 💎 Ruby (RubyGems)

```bash
gem install apiverve_diceroller
```

[**View RubyGems Package →**](https://rubygems.org/gems/apiverve_diceroller) | [**Package Code →**](./ruby/)

---

### 🐘 PHP (Packagist)

```bash
composer require apiverve/diceroller
```

[**View Packagist Package →**](https://packagist.org/packages/apiverve/diceroller) | [**Package Code →**](./php/)

---

### 🎯 Dart (pub.dev)

```bash
dart pub add apiverve_diceroller
```

[**View pub.dev Package →**](https://pub.dev/packages/apiverve_diceroller) | [**Package Code →**](./dart/)

---

### 🤖 Android (JitPack)

```gradle
implementation 'com.github.apiverve:diceroller-api:1.0.0'
```

[**Package Code →**](./android/)

---

### 🐹 Go

```bash
go get github.com/apiverve/diceroller-api/go
```

[**Package Code →**](./go/)

---

## Why Use This API?

| Feature | Benefit |
|---------|---------|
| **Multi-language SDKs** | Native packages for JavaScript, Python, C#, Go, and Android |
| **Simple Integration** | Single API key authentication, consistent response format |
| **Production Ready** | 99.9% uptime SLA, served from 24 global regions |
| **Comprehensive Docs** | Full examples, OpenAPI spec, and dedicated support |

---

## Documentation

- 🏠 **API Home:** [Dice Roller API](https://apiverve.com/marketplace/diceroller?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)
- 📚 **API Reference:** [docs.apiverve.com/ref/diceroller](https://docs.apiverve.com/ref/diceroller)
- 📖 **OpenAPI Spec:** [openapi.yaml](./openapi.yaml)
- 💡 **Examples:** [examples/](./examples/)

---

## What Can You Build?

The Dice Roller API is commonly used for:

- **Web Applications** - Add dice roller features to your frontend or backend
- **Mobile Apps** - Native SDKs for Android development
- **Automation** - Integrate with n8n, Zapier, or custom workflows
- **SaaS Products** - Enhance your product with dice roller capabilities
- **Data Pipelines** - Process and analyze data at scale

---

## API Reference

### Authentication
All requests require an API key in the header:
```
x-api-key: YOUR_API_KEY_HERE
```

Get your API key: [https://apiverve.com](https://apiverve.com)

### Response Format

Every APIVerve endpoint returns the same envelope — check `status`, then read `data`:

```json
{
  "status": "ok",
  "error": null,
  "data": { ... }
}
```

### Example Response

A real response from the Dice Roller API:

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

---

## Support & Community

- 🏠 **API Home**: [Dice Roller API](https://apiverve.com/marketplace/diceroller?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)
- 💬 **Support**: [https://apiverve.com/contact](https://apiverve.com/contact)
- 🐛 **Issues**: [GitHub Issues](../../issues)
- 📖 **Documentation**: [https://docs.apiverve.com](https://docs.apiverve.com)
- 🌐 **Website**: [https://apiverve.com](https://apiverve.com)

---

## Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

---

## Security

For security concerns, please review our [Security Policy](SECURITY.md).

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

Built with ❤️ by [APIVerve](https://apiverve.com)

Copyright © 2026 APIVerve. All rights reserved.
