# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_diceroller"
  spec.version       = "1.2.3"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "Dice Roller API - Ruby Client"
  spec.description   = "Dice Roller is a dice API that simulates RPG dice rolls using standard notation like 3d6 or 2d20 with optional modifiers. It outputs the individual die outcomes, die count, and the sum of all rolls."
  spec.homepage      = "https://apiverve.com/marketplace/diceroller?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/diceroller-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/diceroller"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
